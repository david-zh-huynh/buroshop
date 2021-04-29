package servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Bestellung;
import model.BestellungenDBUtil;
/**
 * Servlet implementation class BestellungServlet
 */
@WebServlet("/BestellungServlet")
public class BestellungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BestellungServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Resource (name="jbdc/kunden_browser")
    private DataSource dataSource;
    private BestellungenDBUtil BestDBUtil;
    
    @Override
	public void init() throws ServletException {
    	BestDBUtil = new BestellungenDBUtil(dataSource);
		super.init();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Liste zur übertragung von den Werten der ArrayList
				List<Bestellung> bestellListe = getBestellListe();
				request.setAttribute("bestell_Liste", bestellListe);
				
				// Die Bestellungen werden in der bestellungen.jsp Datei angezeigt.
				RequestDispatcher dispatcher = request.getRequestDispatcher("/bestellungen.jsp");
				dispatcher.forward(request, response);
			}
	
	

			
			// Hilfs-Methode um die Bestellliste vom Dao zu erhalten 
			private List<Bestellung> getBestellListe() {
				
				try {
					return BestDBUtil.getbestellungen();
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
				
			}

}
