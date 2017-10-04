package pl.pawel.schronisko.filter;

import pl.pawel.schronisko.model.User;
import pl.pawel.schronisko.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        if (httpServletRequest.getUserPrincipal()!= null && httpServletRequest.getSession().getAttribute("user") != null)
        {
            saveUserinSession(httpServletRequest);
        }
        chain.doFilter(req, resp);
    }

    private void saveUserinSession(HttpServletRequest request) {
        UserService userService = new UserService();
        String username = request.getUserPrincipal().getName();
        User userByUsername = userService.getUserByUsername(username);
        request.getSession().setAttribute("user", userByUsername);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
