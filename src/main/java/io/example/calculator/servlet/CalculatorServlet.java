package io.example.calculator.servlet;

import io.example.calculator.domain.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet implements Servlet {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorServlet.class);
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        logger.info("init servlet");
        this.servletConfig = servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("service");
        int firstOperand = Integer.parseInt(servletRequest.getParameter("firstOperand"));
        String operator = servletRequest.getParameter("operator");
        int secondOperand = Integer.parseInt(servletRequest.getParameter("secondOperand"));

        int result = Calculator.calculate(firstOperand, operator, secondOperand);

        PrintWriter writer = servletResponse.getWriter();
        writer.println(result);
    }

    @Override
    public void destroy() {
        // resource release
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
