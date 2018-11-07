jQuery.Huitab =function(tabBar,tabCon,class_name,tabEvent,i){
    var $tab_menu=$(tabBar);
    // 初始化操作
    $tab_menu.removeClass(class_name);
    $(tabBar).eq(i).addClass(class_name);
    $(tabCon).hide();
    $(tabCon).eq(i).show();

    $tab_menu.bind(tabEvent,function(){
        $tab_menu.removeClass(class_name);
        $(this).addClass(class_name);
        var index=$tab_menu.index(this);
        $(tabCon).hide();
        $(tabCon).eq(index).show()})}
$.Huitab("#tab_demo .tabBar span","#tab_demo .tabCon","current","click","0");


// 路径配置
require.config({
    paths: {
        echarts: ctx+'/static/lib/echarts'
    }
});
// 使用
require(
    [
        'echarts',
        'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
    ],
    function (ec) {
        // 基于准备好的dom，初始化echarts图表
        var myChart = ec.init(document.getElementById('chart'),'shine');

        var option = {
            title : {
                text: '财务总收入',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient : 'vertical',
                x : 'left',
                data:['QC订单收入','平台跟单收入','保证金收入']
            },
            toolbox: {
                show : true,
                feature : {
                    dataView : {show: true, readOnly: false},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            series : [
                {
                    name:'财务总收入',
                    type:'pie',
                    radius : '60%',
                    center: ['50%', '60%'],
                    data:[
                        {value:qcSum, name:'QC订单收入'},
                        {value:weSum, name:'平台跟单收入'},
                        {value:insureSum, name:'保证金收入'}
                    ]
                }
            ]
        };
        // 为echarts对象加载数据
        myChart.setOption(option);


        // 基于准备好的dom，初始化echarts图表
        var myChart2 = ec.init(document.getElementById('chart2'),'shine');

        var option2 = {
            title : {
                text: '财务总支出',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient : 'vertical',
                x : 'left',
                data:['QC用户提现支出','PC用户提现支出']
            },
            toolbox: {
                show : true,
                feature : {
                    dataView : {show: true, readOnly: false},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            series : [
                {
                    name:'财务总支出',
                    type:'pie',
                    radius : '60%',
                    center: ['50%', '60%'],
                    data:[
                        {value:qcExpend, name:'QC用户提现支出'},
                        {value:pcExpend, name:'PC用户提现支出'}
                    ]
                }
            ]
        };
        // 为echarts对象加载数据
        myChart2.setOption(option2);
    }
);

