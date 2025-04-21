package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SortServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем строку чисел от пользователя
        String numbers = request.getParameter("numbers");

        // Разделяем строку по запятой
        String[] strNumbers = numbers.split(",");

        // Преобразуем строки в целые числа
        int[] intNumbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            intNumbers[i] = Integer.parseInt(strNumbers[i].trim());
        }

        // Сортируем массив чисел
        Arrays.sort(intNumbers);

        // Отправляем отсортированный массив обратно на страницу
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Отсортированные числа:</h3>");
        out.println("<ul>");
        for (int num : intNumbers) {
            out.println("<li>" + num + "</li>");
        }
        out.println("</ul>");
        out.println("<a href='index.html'>Назад</a>");
        out.println("</body></html>");
    }
}
