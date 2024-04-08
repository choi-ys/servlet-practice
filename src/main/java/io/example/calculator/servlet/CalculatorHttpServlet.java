package io.example.calculator.servlet;

import io.example.calculator.domain.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/generic/calculate")
public class CalculatorHttpServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorHttpServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("service");
        int firstOperand = Integer.parseInt(request.getParameter("firstOperand"));
        String operator = request.getParameter("operator");
        int secondOperand = Integer.parseInt(request.getParameter("secondOperand"));

        int result = Calculator.calculate(firstOperand, operator, secondOperand);

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }
}
