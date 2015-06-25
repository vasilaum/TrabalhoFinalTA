package filters;

import controle.ControleLogin;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/privado/*")
public class FiltroSegurança implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession sessao = httpRequest.getSession();
        String contexPath = httpRequest.getContextPath();
        ControleLogin controleLogin = (ControleLogin)sessao.getAttribute("controleLogin");
        if(controleLogin == null || controleLogin.getFuncionarioLogado()== null){
            httpResponse.sendRedirect(contexPath+"/login.xhtml");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
    
}
