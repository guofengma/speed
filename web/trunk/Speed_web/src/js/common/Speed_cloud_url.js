

var Speed_cloud_url = {
    "switch":"test",//1.dev（开发环境） 2.test（内部测试服务） 3.formal（阿里云服务器）4.interface接口测试。
    "api":"123",
}

if (Speed_cloud_url.switch  === 'dev') {
    Speed_cloud_url.api = 'https://www.nicholeyep.com:8455/speedapi/'
}else if(Speed_cloud_url.switch  === 'test'){
    Speed_cloud_url.api = 'https://www.nicholeyep.com:8455/speedapi/'
}else if(Speed_cloud_url.switch  === 'formal'){
    Speed_cloud_url.api = 'https://www.nicholeyep.com:8455/speedapi/'
}else if(Speed_cloud_url.switch == "interface"){
	Speed_cloud_url.api = 'http://192.168.0.118:8085/speedapi/'
}else{
	//内部测试服务器
	  Speed_cloud_url.api = 'https://www.nicholeyep.com:8455/speedapi/'
}

var Speed_cloud_param = {
    
}
console.log(Speed_cloud_url.api)
