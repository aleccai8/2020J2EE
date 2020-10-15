package com.j2ee.homework2.servlet;

import com.j2ee.homework2.servlet.data.PeopleExcelDataVO;
import com.j2ee.homework2.servlet.utils.ExcelReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    private List<PeopleExcelDataVO> list;

    @Override
    public void init() throws ServletException {
        String path = SearchServlet.class.getResource("/").getPath();
        path = "/"+path.substring(1,path.indexOf("classes")) + "contact/data.xlsx";
        System.out.println(path);
        list = ExcelReader.readExcel(path);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        String option = req.getParameter("option");
        int displayNumber = Integer.parseInt(req.getParameter("displayNumber"));
        int page = Integer.parseInt(req.getParameter("page"));
        if(param == null || param.equals("")){
            resp.sendRedirect(req.getContextPath() + "/search");
            return;
        }
        List<PeopleExcelDataVO> result = new LinkedList<>();
        for (PeopleExcelDataVO item : list) {
            if (option.equals("id") && item.getId().equals(param)) {
                result.add(item);
                break;
            } else if (option.equals("name") && item.getName().contains(param)) {
                result.add(item);
            } else if (option.equals("phone") && item.getPhone().equals(param)) {
                result.add(item);
                break;
            } else if (option.equals("qq") && item.getQq().equals(param)) {
                result.add(item);
            } else if (option.equals("email") && item.getEmail().equals(param)) {
                result.add(item);
            }
        }
        int startIndex = displayNumber * (page-1);
        int endIndex = Math.min(result.size(), displayNumber * page);
        int totalPage = result.size()/displayNumber + 1;
        if(startIndex>endIndex){
            resp.sendRedirect(req.getContextPath() + "/search");
        }
        result = result.subList(startIndex ,endIndex);
        req.setAttribute("table",result);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("currentPage",page);
        req.setAttribute("param",param);
        req.setAttribute("option",option);
        req.setAttribute("displayNumber",displayNumber);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        req.getRequestDispatcher("/result.jsp").forward(req,resp);
    }
}
