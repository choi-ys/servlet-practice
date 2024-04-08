package io.example.calculator.servlet;

import io.example.calculator.domain.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/generic/calculate")
public class CalculatorGenericServlet extends GenericServlet {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorGenericServlet.class);

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
}
