			    	$(".datepicker").datepicker({
			    		format: 'yyyy-mm-dd',
			    	});

//			         function addEmployee() {
//				      	var topWin = window.top.document.getElementById("mainFrame").contentWindow;
//						var myform = topWin.document.getElementById("infoinput");
//						myform.action = "employee/addEmployee_Employee";
//						myform.method = "post";
//						myform.submit();
//					}

					function modifyEmployee() {
						var mainframe = window.frames['mainFrame'];
						var myform = mainframe.contentDocument.getElementById('infoinput');
						myform.action = "employee/modifyEmployee_success";
						myform.method = "post";
						myform.submit();
					}

					for(var i = 1 ; i < 12; i++){
						var em = new LiveValidation("f"+i,
													{ validMessage: " ", wait: 500 },
													{onlyOnSubmit: true } 
												);
						em.add( Validate.Presence ,{ failureMessage: "必填" });
					}

					var em = new LiveValidation("email",
													{ validMessage: " ", wait: 500 },
													{onlyOnSubmit: true } 
												);
					em.add( Validate.Email ,{ failureMessage: "格式错误" });
					em.add( Validate.Presence ,{ failureMessage: "必填" });

			    var   level   =   ["无",    "一级",   "二级",   "三级",   "四级",   "五级",   "六级",   "七级",   "八级",   "九级",   "十级"]; 
			    var   work   =   ["无",    "正部级",   "副部级",   "正厅级",   "副厅级",   "正处级",   "副处级",   "正科级",   "副科级",   "科员",   "办事员"]; 
          var   title   =   ["无",    "正高级",   "副高级",   "中级",   "助理级",   "员级"];
					var   titlelevel   =   ["无",    "一级",   "二级",   "三级",   "四级",   "五级",   "六级",   "七级",   "八级",   "九级",   "十级",   "十一级",   "十二级",   "十三级"];
          var   hirejob   =   ["无",    "高级技工",   "技师",   "高级工",   "中级工",   "初级工",   "普通工"];
          var   joblevel   =   ["无",    "技术工一级",   "技术工二级",   "技术工三级",   "技术工四级",   "技术工五级",   "普通工"];

					function showA(n){
 			   			var se=document.getElementById("worklevel");
						var i=0;
 						for(i=11;i>=0;i--){
   							se.remove(i);
  						}
  						for(var j= 1;j <=10 ;j++)
 							if(n==j){
  								var op=document.createElement("option");
  								op.value=level[j];
  								op.text=level[j];
  								se.add(op);
  							}
  						if(n==0)
  							for(var k=0; k<=10; k++){
  								var op=document.createElement("option");
  								op.value=level[k];
  								op.text=level[k];
  								se.add(op);
  						}

					}

					function showB(n){
 			   			var se=document.getElementById("hirework");
						var i=0;
 						for(i=11;i>=0;i--){
   							se.remove(i);
  						}
  						for(var j= 1;j <=10 ;j++)
 							if(n==j){
  								var op=document.createElement("option");
  								op.value=work[j];
  								op.text=work[j];
  								se.add(op);
  							}
  						if(n==0)
  							for(var k=0; k<=10; k++){
  								var op=document.createElement("option");
  								op.value=work[k];
  								op.text=work[k];
  								se.add(op);
  						}
  					}

  					function showC(n){
 			   			var se=document.getElementById("titlelevel");
						var i=0;
 						for(i=14;i>=0;i--){
   							se.remove(i);
  						}
  						
 						if(n==1){
 							for(var k=0; k<=4; k++){
  								var op=document.createElement("option");
  								op.value=titlelevel[k];
  								op.text=titlelevel[k];
  								se.add(op);
  							}
  						}
  						if(n==2){
 							var op=document.createElement("option");
  							op.value=titlelevel[0];
  							op.text=titlelevel[0];
  							se.add(op);
 							for(var k=5; k<=7; k++){
  								var op=document.createElement("option");
  								op.value=titlelevel[k];
  								op.text=titlelevel[k];
  								se.add(op);
  							}
  							
  						}
  						if(n==3){
 							var op=document.createElement("option");
  							op.value=titlelevel[0];
  							op.text=titlelevel[0];
  							se.add(op);
 							for(var k=8; k<=10; k++){
  								var op=document.createElement("option");
  								op.value=titlelevel[k];
  								op.text=titlelevel[k];
  								se.add(op);  								
  							}
  						}
  						if(n==4){
  							var op=document.createElement("option");
  							op.value=titlelevel[0];
  							op.text=titlelevel[0];
  							se.add(op);
 							for(var k=11; k<=12; k++){
  								var op=document.createElement("option");
  								op.value=titlelevel[k];
  								op.text=titlelevel[k];
  								se.add(op);
  							}
  						}
  						if(n==5){  														
 							var op=document.createElement("option");
  							op.value=titlelevel[13];
  							op.text=titlelevel[13];
  							se.add(op);  							
  						}
  						if(n==0)
  							for(var k=0; k<=13; k++){
  								var op=document.createElement("option");
  								op.value=titlelevel[k];
  								op.text=titlelevel[k];
  								se.add(op);
  						}
  					}

  					function showD(n){

 			   			var se=document.getElementById("hiretitle");
              var re=document.getElementById("titlelevel");
              if(se.options.length == 6 && re.options.length != 14)
                  return;
						  var i=0;
 						  for(i=6;i>=0;i--){
   							  se.remove(i);
  						}
  						
 						  if(n==1||n==2||n==3||n==4){
  							 var op=document.createElement("option");
  							 op.value=title[1];
  							 op.text=title[1];
  							 se.add(op);
  						}
  						if(n==5||n==6||n==7){
  							var op=document.createElement("option");
  							op.value=title[2];
  							op.text=title[2];
  							se.add(op);
  						}
  						if(n==8||n==9||n==10){
  							var op=document.createElement("option");
  							op.value=title[3];
  							op.text=title[3];
  							se.add(op);
  						}
  						if(n==11||n==12){
  							var op=document.createElement("option");
  							op.value=title[4];
  							op.text=title[4];
  							se.add(op);
  						}
  						if(n==13){
  							var op=document.createElement("option");
  							op.value=title[5];
  							op.text=title[5];
  							se.add(op);
  						}
  						if(n==0)
  							for(var k=0; k<=5; k++){
  								var op=document.createElement("option");
  								op.value=title[k];
  								op.text=title[k];
  								se.add(op);
  						}
  					}

            function showE(n){
              var se=document.getElementById("joblevel");
              var i=0;
              for(i=6;i>=0;i--){
                se.remove(i);
              }
              for(var j= 1;j <=6 ;j++)
              if(n==j){
                  var op=document.createElement("option");
                  op.value=joblevel[j];
                  op.text=joblevel[j];
                  se.add(op);
                }
              if(n==0)
                for(var k=0; k<=6; k++){
                  var op=document.createElement("option");
                  op.value=joblevel[k];
                  op.text=joblevel[k];
                  se.add(op);
              }

            }


            function showF(n){
              var se=document.getElementById("hirejob");
              var i=0;
              for(i=6;i>=0;i--){
                se.remove(i);
              }
              for(var j= 1;j <=6 ;j++)
              if(n==j){
                  var op=document.createElement("option");
                  op.value=hirejob[j];
                  op.text=hirejob[j];
                  se.add(op);
                }
              if(n==0)
                for(var k=0; k<=6; k++){
                  var op=document.createElement("option");
                  op.value=hirejob[k];
                  op.text=hirejob[k];
                  se.add(op);
              }
            }