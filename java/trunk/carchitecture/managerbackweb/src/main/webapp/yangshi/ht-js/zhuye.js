//ajax��ȡ�����˵�
var templatenav="";
	$.ajax({
            //����������Ҫע��һ��
                type: "GET",//��������
                dataType: "json",//Ԥ�ڷ��������ص���������
                url: "menu/getGjMenus.do" ,//url
               // data:{id:$(this).attr("data-id")},
                success: function (result) {
                    console.log(result.data);//��ӡ����˷��ص�����(������)
                  templatenav=result.data;
                   console.log(templatenav)                  
                   setnav();
                },             
            });
	$("#search::after").click(function(){
		alert(11111)
	})