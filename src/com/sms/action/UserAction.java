package com.sms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.components.Else;

import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.User;
import com.sms.security.Md5;
import com.sms.service.IUserManage;

import freemarker.core.ReturnInstruction.Return;

public class UserAction extends ActionSupport {

	private User user;

	@Resource
	private IUserManage userManage;
	
	public boolean isPasswordValid(String password)
	{
		if (password.length() < 6)
			return false;
		return true;
	}

	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}
	
	public void setUserManage(IUserManage userManage) {
		this.userManage = userManage;
	}

	public IUserManage getUserManage() {
		return userManage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String path;
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String addUser() {
		System.out.println("-------userAction.addUser--------" + user.getId());
		if (isValid(user.getId()) && isPasswordValid(user.getPassword()))
		{
			System.out.println("用户增加成功");
			userManage.addUser(user);
			return "success";
		}
		System.out.println("密码长度不够");
		return "fail";
	}

	public String modifyUser() {
		System.out.println("-------userAction.modifyUser--------" + user.getId());
		if (isValid(user.getId()) && userManage.findUserById(user.getId()) != null && isPasswordValid(user.getPassword()))
		{			
			userManage.modifyUser(user);
			return "success";
		}
		System.out.println("密码长度不够");
		return "fail";
	}

	public String deleteUser() {
		System.out.println("-------userAction.deleteUser--------" + user.getId());
		
		if (Md5.validatePassword(userManage.findUserById(user.getId()).getPassword(), user.getPassword()))
		{
			userManage.deleteUser(user);
			return "success";
		}
		System.out.println("密码错误");
		return "fail";
	}
	
	public String importUser() throws Exception {
		String id = null;
		String password = null;
		String userType = null;
		
		Workbook workbook = null;
		int k = 0;
		int flag = 0;
		
		System.out.println("I am here!");
		
		if (path != null)
		{
			try {
				workbook = new XSSFWorkbook(path);
				for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
					System.out.println("2007版进去读取Sheet的循环");
					if (workbook.getSheetAt(numSheets) != null) {
						XSSFSheet aSheet = (XSSFSheet)workbook.getSheetAt(numSheets);
						for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
							if (aSheet.getRow(rowNumOfSheet) != null) {
								XSSFRow aRow = aSheet.getRow(rowNumOfSheet);
								for (int cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {
									XSSFCell xCell = aRow.getCell(cellNumOfRow);
									
									if (aRow.getCell(cellNumOfRow) != null) {
										if (rowNumOfSheet == 0) 
										{
											if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) 
											{												
											}else if (xCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN)
											{
											}else if (xCell.getCellType() == XSSFCell.CELL_TYPE_STRING)
											{
												if (cellNumOfRow == 0)
												{
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("职工号"))
													{
														flag++;
													}else {
														System.out.println("错误：第一行职工号不符合约定格式");
													}
												}else if (cellNumOfRow == 1)
												{
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("密码"))
													{
														flag++;
													}else {
														System.out.println("错误：第一行密码不符合约定格式");
													}
												}else if (cellNumOfRow == 2)
												{
													if (xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("类型"))
													{
														flag++;
													}else {
														System.out.println("错误：第一行类型不符合约定格式");
													}
												}
											}
										}
										else {
											if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
											{
												if (cellNumOfRow == 0)
												{
													id = String.valueOf(xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
													if (id == null)
														System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的职工号不能为空");
												}else if (cellNumOfRow == 1)
												{
													password = String.valueOf(xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
													if (id == null)
														System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的密码不能为空");
												}else if (cellNumOfRow == 2)
												{
													userType = String.valueOf(xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
													if (id == null)
														System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的类型不能为空");
												}
											}else if (xCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
												System.out.println("===============进入XSSFCell .CELL_TYPE_STRING模块============");
												if (cellNumOfRow == 0)
												{
													id = String.valueOf(xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
													if (id == null)
														System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的职工号不能为空");
												}else if (cellNumOfRow == 1)
												{
													password = String.valueOf(xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
													if (id == null)
														System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的密码不能为空");
												}else if (cellNumOfRow == 2)
												{
													userType = String.valueOf(xCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
													if (id == null)
														System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的类型不能为空");
												}
											}else if (xCell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
												System.out.println("提示：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的值为空，请查看核对是否符合约定要求");
											}
										}
									}
								}
								if (flag != 3) {
									System.out.println("请核对后重试");
								}
							}
							if (id != null && password != null && userType != null) {
								user.setId(Integer.parseInt(id));
								user.setPassword(Md5.generatePassword(password));
								user.setUserType(Integer.parseInt(userType));
								userManage.addUser(user);
								k++;
							}
						}
					}
				}
			}catch (Exception e) {
				InputStream is = new FileInputStream(path);
				workbook = new HSSFWorkbook(is);
				try {
					for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
						System.out.println("2003版进去读取Sheet的循环");
						if (workbook.getSheetAt(numSheets) != null) {
							HSSFSheet aSheet = (HSSFSheet)workbook.getSheetAt(numSheets);
							for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
								if (aSheet.getRow(rowNumOfSheet) != null) {
									HSSFRow aRow = aSheet.getRow(rowNumOfSheet);
									for (int cellNumOfRow = 0; cellNumOfRow < aRow.getLastCellNum(); cellNumOfRow++) {
										HSSFCell aCell = aRow.getCell(cellNumOfRow);
										if (aRow.getCell(cellNumOfRow) != null) {
											if (rowNumOfSheet == 0) {
												if (aCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
												}else if (aCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
												}else if (aCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
													if (cellNumOfRow == 0) {
														if (cellNumOfRow == 0) {
															if (aCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("职工号")) {
																flag++;
																System.out.println("=======flag:" + flag);
															}else {
																System.out.println("错误：第一行的职工号不符合约定格式");
															}
														}else if (cellNumOfRow == 1) {
															if (aCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("密码")) {
																flag++;
																System.out.println("=======flag:" + flag);
															}else {
																System.out.println("错误：第一行的密码不符合约定格式");
															}
														}else if (cellNumOfRow == 2) {
															if (aCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim().equals("类型")) {
																flag++;
																System.out.println("=======flag:" + flag);
															}else {
																System.out.println("错误：第一行的类型不符合约定格式");
															}
														}
													}
												}
												else {
													if (aCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
														System.out.println("======进入XSSFCell .CELL_TYPE_NUMERIC模块==========");
														if (cellNumOfRow == 0) {
															id = String.valueOf(aCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
															if (id == null) {
																System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的职工号不能为空");
															}
														}else if (cellNumOfRow == 1) {
															password = String.valueOf(aCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
															if (password == null) {
																System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的密码不能为空");
															}
														}else if (cellNumOfRow == 2) {
															userType = String.valueOf(aCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
															if (userType == null) {
																System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的类型不能为空");
															}
														}
													}else if (aCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
														System.out.print("===============进入XSSFCell .CELL_TYPE_STRING模块============");
														if (cellNumOfRow == 0) {
															id = String.valueOf(aCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
															if (id == null) {
																System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的职工号不能为空");
															}
														}else if (cellNumOfRow == 1) {
															password = String.valueOf(aCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
															if (password == null) {
																System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的密码不能为空");
															}
														}else if (cellNumOfRow == 2) {
															userType = String.valueOf(aCell.getStringCellValue().replace('\t', ' ').replace('\n', ' ').replace('\r', ' ').trim());
															if (userType == null) {
																System.out.println("错误：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的类型不能为空");
															}
														}
													}else if (aCell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
														System.out.println("提示：在Sheet"+(numSheets+1)+"中的第"+(rowNumOfSheet+1)+"行的第"+(cellNumOfRow+1)+"列的值为空，请查看核对是否符合约定要求".toString());
													}
												}
											}
										}
										if (flag != 3) {
											System.out.println("请核对后重试");
										}
									}
									if (id != null && password != null && userType != null) {
										user.setId(Integer.parseInt(id));
										user.setPassword(Md5.generatePassword(password));
										user.setUserType(Integer.parseInt(userType));
										k++;
									}
								}
								if (k != 0) {
									System.out.println("提示：您导入的数据已存在于数据库，请核对！k 为：" + k);
								}
								else {
									System.out.println("提示：成功导入了"+k+"条数据");
								}
							}
						}
					}
				}catch (Exception ex) {
					ex.printStackTrace();
				}finally {
					try {
						if (is != null) {
							is.close();
						}
					}catch (Exception el) {
						el.printStackTrace();
					}
				}
			}
			return null;
		}
		return "fail";
	}	
}
