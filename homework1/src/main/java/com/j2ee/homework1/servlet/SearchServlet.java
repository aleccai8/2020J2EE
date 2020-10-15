package com.j2ee.homework1.servlet;

import com.j2ee.homework1.servlet.data.PeopleExcelDataVO;
import com.j2ee.homework1.servlet.utils.ExcelReader;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.InflaterInputStream;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private List<PeopleExcelDataVO> list;
    @Override
    public void init() throws ServletException {
        String path = SearchServlet.class.getResource("/").getPath();
        path = "/"+path.substring(1,path.indexOf("classes")) + "contact/data.xlsx";
        System.out.println(path);
        list = ExcelReader.readExcel(path);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.getRequestDispatcher("/search.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,NumberFormatException{

        String param = request.getParameter("param");
        String option = request.getParameter("option");
        int count = Integer.parseInt(request.getParameter("count"));
        if(param == null || param.equals("")){
            response.sendRedirect(request.getRequestURI());
            return;
        }
        List<PeopleExcelDataVO> result = new LinkedList<>();
        Iterator<PeopleExcelDataVO> iter = list.iterator();
        while(iter.hasNext() && result.size() < count){
            PeopleExcelDataVO item = (PeopleExcelDataVO) iter.next();
            if(option.equals("id") && item.getId().equals(param)){
                result.add(item);
                break;
            }else if(option.equals("name") && item.getName().contains(param)){
                result.add(item);
            }else if(option.equals("phone") && item.getPhone().equals(param)){
                result.add(item);
                break;
            }else if(option.equals("qq") && item.getQq().equals(param)){
                result.add(item);
            }else if(option.equals("email")&& item.getEmail().equals(param)){
                result.add(item);
            }
        }
        request.setAttribute("table",result);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

}
