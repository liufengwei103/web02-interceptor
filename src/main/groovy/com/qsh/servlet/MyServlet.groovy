package com.qsh.servlet

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
/**
 * 1.继承原生servlet(extends HttpServlet )或实现servlet接口
 * 2.标注注解@WebServlet
 *      标注注解后，重写doGet()方法
 * 3.配置servlet能处理的请求路径
 * 4.让此servlet生效：
 *      在主类中添加注解@ServletComponentScan,能自动的将我们写的servlet扫描进来；
 *      basePackages = "com.qsh"  该包下的任何一个子包有servlet都能被扫描到
 */

//@WebServlet(urlPatterns = "/my")
class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //测试：请求发过来，给写一段数字返回
        resp.getWriter().write("66666666")
    }
}
