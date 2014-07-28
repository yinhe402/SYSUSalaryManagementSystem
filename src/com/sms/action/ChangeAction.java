package com.sms.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.sms.entity.DepartmentChange;
import com.sms.exception.ExcelException;
import com.sms.service.IDepartmentChangeManage;
import com.sms.service.IEmployeeManage;
import com.sms.util.ExcelUtil;

import java.util.Date;

public class ChangeAction {
	
	private DepartmentChange departmentChange;
	
	public DepartmentChange getDepartmentChange() {
		return departmentChange;
	}

	public void setDepartmentChange(DepartmentChange departmentChange) {
		this.departmentChange = departmentChange;
	}
	
	@Resource
	private IDepartmentChangeManage departmentChangeManage;
	
	public IDepartmentChangeManage getDepartmentChangeManage() {
		return departmentChangeManage;
	}

	public void setDepartmentChangeManage(
			IDepartmentChangeManage departmentChangeManage) {
		this.departmentChangeManage = departmentChangeManage;
	}

	@Resource
	private IEmployeeManage employeeManage;
	
	public IEmployeeManage getEmployeeManage() {
		return employeeManage;
	}

	public void setEmployeeManage(IEmployeeManage employeeManage) {
		this.employeeManage = employeeManage;
	}

	
	//职工号是否有效
	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}	
	
	public String SchoolInnerChange() {
		System.out.println("-------changeAction.SchoolInnerChange--------" + departmentChange.getEId());
		if (!isValid(departmentChange.getEId()))
			return "fail";
		if (employeeManage.findEmployeeById(departmentChange.getEId()) == null)
			return "fail";
		if (employeeManage.findEmployeeById(departmentChange.getEId()).getName().equals(departmentChange.getName()) && employeeManage.findEmployeeById(departmentChange.getEId()).getDepartment().equals(departmentChange.getOldDepartment())) {
			employeeManage.findEmployeeById(departmentChange.getEId()).setDepartment(departmentChange.getNewDepartment());
			departmentChangeManage.addDepartmentChange(departmentChange);
			return "success";
		}
		return "fail";
	}
	
	public String InfoExport() {
		System.out.println("-------changeAction.InfoExport--------" + departmentChange.getEId());
		/*if (SchoolInnerChange().equals("success")true) {
			List<DepartmentChange> lst = new ArrayList<DepartmentChange>();
			DepartmentChange newDepartmentChange = new DepartmentChange();
			
			newDepartmentChange.setId(departmentChange.getId());
			newDepartmentChange.setEId(departmentChange.getEId());
			newDepartmentChange.setName(departmentChange.getName());
			newDepartmentChange.setOldDepartment(departmentChange.getOldDepartment());
			newDepartmentChange.setNewDepartment(departmentChange.getNewDepartment());
			newDepartmentChange.setAccording(departmentChange.getAccording());
			newDepartmentChange.setDepChangeDate(new Date());
			newDepartmentChange.setNote(departmentChange.getNote());
			lst.add(newDepartmentChange);
			System.out.println(lst.get(0).getAccording());
			
			LinkedHashMap fieldMap = new LinkedHashMap<String, String>();
			fieldMap.put("eId", "职工号");
			fieldMap.put("name", "姓名");
			fieldMap.put("oldDepartment", "原工作单位");
			fieldMap.put("newDepartment", "新工作单位");
			fieldMap.put("according", "变更依据");
			fieldMap.put("note", "备注");
			
			String fileName = "InnerChangeStartSalary";
			HttpServletResponse response = null;
			response = ServletActionContext.getResponse();
			response.reset();
	        response.setContentType("application/vnd.ms-excel");        //改成输出excel文件  
	        response.setHeader("Content-disposition","attachment; filename="+fileName+".xls" );  
	  
	        try {  	         
	        	OutputStream output = response.getOutputStream();
	            ExcelUtil.listToExcel(lst, fieldMap, "内部调动起薪表", output);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
			
			return null;
		}*/
		/*return "fail";*/
		if (true) {
			List<DepartmentChange> lst = new ArrayList<DepartmentChange>();
			departmentChange.setDepChangeDate(new Date());
			lst.add(departmentChange);
			String []tableHeader={"职工号","姓名","原工作单位","新工作单位","变更依据","备注"};
			short cellNumber = (short)tableHeader.length;
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFCell cell = null;
			HSSFRow row = null;
			HSSFCellStyle style_header = workbook.createCellStyle();
			style_header.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style_data = workbook.createCellStyle();
			style_data.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFFont font = workbook.createFont();
			HSSFSheet sheet = workbook.createSheet("InnerChangeStartSalary");
			HSSFHeader header = sheet.getHeader();
			try {
				if (lst.size() < 1) {
					header.setCenter("查无资料");
				}
				else {
					header.setCenter("InnerChangeStartSalary");
					row = sheet.createRow(0);
					row.setHeight((short)400);
					for (int k = 0; k < cellNumber; k++) {
						cell = row.createCell(k);
						cell.setCellValue(tableHeader[k]);
						sheet.setColumnWidth(k, 8000);
						font.setColor(HSSFFont.COLOR_NORMAL);
						font.setFontHeight((short)350);
						style_data.setFont(font);
						cell.setCellStyle(style_data);
					}
					DepartmentChange newDepartmentChange = new DepartmentChange();
					for (int i = 0; i < lst.size(); i++)
					{
						newDepartmentChange = lst.get(i);
						row = sheet.createRow((short)(i+1));
						row.setHeight((short)400);
						
						cell = row.createCell(0);
						cell.setCellValue(newDepartmentChange.getEId());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(1);
						cell.setCellValue(newDepartmentChange.getName());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(2);
						cell.setCellValue(newDepartmentChange.getOldDepartment());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(3);
						cell.setCellValue(newDepartmentChange.getNewDepartment());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(4);
						cell.setCellValue(newDepartmentChange.getAccording());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(5);
						cell.setCellValue(newDepartmentChange.getNote());
						cell.setCellStyle(style_header);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			HttpServletResponse response = null;//创建一个HttpServletResponse对象
			OutputStream out = null;//创建一个输出流对象
			try {
				response = ServletActionContext.getResponse();//初始化HttpServletResponse对象
				out = response.getOutputStream();//
		        response.setHeader("Content-disposition","attachment; filename="+"InnerChangeStartSalary.xls");//filename是下载的xls的名，建议最好用英文
		        response.setContentType("application/msexcel;charset=UTF-8");//设置类型
		        response.setHeader("Pragma","No-cache");//设置头
		        response.setHeader("Cache-Control","no-cache");//设置头
		        response.setDateHeader("Expires", 0);//设置日期头
		        workbook.write(out);
		        out.flush();
				workbook.write(out);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try{					
					if(out!=null){
						out.close();
					}					
				}catch(IOException e){
					e.printStackTrace();
				}				
			}
			return null;
		}
		return "fail";
	}
}