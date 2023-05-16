package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        List<String> companies = new ArrayList<>();
        String parameter = request.getQueryString();
        String value = request.getParameter("search");
        PrintWriter out = response.getWriter();

        if (parameter == null || value == null) {
            companies = getCompanies();
        } else {
            List<String> compList = getCompanies().stream()
                    .filter(i -> i.contains(value))
                    .collect(Collectors.toList());
            if (compList.size() == 0) {
                out.println("Companies not found");
            } else {
                companies = compList;
            }
        }
        for (var company : companies) {
            out.println(company);
        }
        // END
    }
}
