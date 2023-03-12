package org.example.servlet;

import org.example.calculator.Calculator;
import org.example.calculator.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet  extends GenericServlet {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        logger.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);

    }

}
