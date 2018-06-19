package com.spring.view;

import com.spring.mapper.PermissiontbMapper;
import com.spring.page.Page;
import com.spring.pojo.Permissiontb;
import com.spring.util.PoiUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/excel" , name = "表格")
public class Excel {

    @Autowired
    PoiUtils poiUtils;

    @Autowired
    PermissiontbMapper mapper;

    /**
     * 下载权限excel表格
     */
    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {

        // 定义表头
        String[] tableHeader = {"权限ID","权限地址","权限所属模块","权限名","最后修改时间"};
        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 设置单元格样式
        HSSFCellStyle style = workbook.createCellStyle();
        //居中
        style.setAlignment(HorizontalAlignment.CENTER);
        // 创建第一个工作表
        HSSFSheet sheet = workbook.createSheet("权限表");
        // 创建第一行
        HSSFRow row = sheet.createRow(0);

        for (int i = 0 ; i<tableHeader.length;i++){
            // 创建单元格
            HSSFCell cell = row.createCell(i);
            // 给单元格设置内容
            cell.setCellValue(tableHeader[i]);
            //将单元格居中
            cell.setCellStyle(style);
            //自动添加列
            sheet.autoSizeColumn(i);
            //列宽
            sheet.setColumnWidth(i,50*100);
        }

        // 获取要导出
        List<Permissiontb> list =mapper.selectPermissionAll();;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < list.size(); i++) {
            // 从第二行开始
            HSSFRow hssfRow = sheet.createRow(i+1);
            // 每一行对应的学生
            Permissiontb permissiontbs = list.get(i);
            // 给每个单元格赋值
            hssfRow.createCell(0).setCellValue(permissiontbs.getPermissionid());
            hssfRow.createCell(1).setCellValue(permissiontbs.getPermissionvalue());
            hssfRow.createCell(2).setCellValue(permissiontbs.getPermissionmodule());
            hssfRow.createCell(3).setCellValue(permissiontbs.getPermissionname());
            hssfRow.createCell(4).setCellValue(simpleDateFormat.format(permissiontbs.getPermissionlastupdatetime()));

        }

        // 设置excel文件名称
        String fileName = "权限.xls";
        //避免下载文件名出现乱码
        fileName = URLEncoder.encode(fileName,"UTF8");
        //开始输出工作簿
        OutputStream outputStream = response.getOutputStream();
        // 重置response设置
        response.reset();
        response.setHeader("Content-disposition", "attachment;filename="+fileName);
        response.setContentType("application/vnd.ms-excel");
        // 发送工作簿
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

    }



    /**
     * 用户上传excel,解析excel,将excel数据加入到数据库中
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Page uploadStuByExcel(@RequestParam("file")MultipartFile file){

        List<String[]> strings = poiUtils.getWorkbookValue(file);
//        List<Students> students = new ArrayList<>();
//        for (String[] str : strings ) {
//
//            Students student = new Students();
//
//            student.setName(str[1]);
//            student.setAge(Integer.valueOf(str[2]));
//            student.setSex(str[3]);
//            student.setPhone(str[4]);
//            student.setStustatus(str[5]);
//
//            student.setPerstate(str[6]);
//            student.setMsgsource(str[7]);
//            student.setAddress(str[8]);
//            student.setQq(str[9]);
//            student.setWeixin(str[10]);
//
//            student.setContent(str[11]);
//            student.setLearnforward(str[12]);
//            student.setIsvalid(str[13]);
//            student.setIspay(str[14]);
//
//            student.setMoney(Double.valueOf(str[15]));
//            student.setCreateuser(str[16]);
//            student.setPremoney(Double.valueOf(str[17]));
//
//            students.add(student);
//
//        }
//
//        return studentService.batchStudents(students);

        return new Page();
    }

}
