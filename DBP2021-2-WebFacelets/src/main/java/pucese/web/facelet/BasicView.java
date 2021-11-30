package pucese.web.facelet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;



@Named("dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Product> products;

	private DualListModel<String> cities;

    @Inject
    private ProductService service;

    @PostConstruct //un metodo que carga datos antes de iniciar la clase...
    public void init() {
        products = service.getProducts(10); //llamando al metodo getProductos de la clase productService
        
        //agregare ciudades
      //Cities
        List<String> citiesSource = new ArrayList<>();
        List<String> citiesTarget = new ArrayList<>();

        citiesSource.add("San Francisco");
        citiesSource.add("London");
        citiesSource.add("Paris");
        citiesSource.add("Istanbul");
        citiesSource.add("Berlin");
        citiesSource.add("Barcelona");
        citiesSource.add("Rome");

        cities = new DualListModel<>(citiesSource, citiesTarget);

       
    }

    
    public void onSelect(SelectEvent<String> event) {
        FacesContext context = FacesContext.getCurrentInstance(); //primefaces facescontext obtiene parametros desde la pagina web
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cities Selected", event.getObject().getClass().toString()));
    }
    
    
    public DualListModel<String> getCities() {
        return cities;
    }

    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }

  

	public List<Product> getProducts() {
		
        return products;
    }

    public void setService(ProductService service) {
        this.service = service;
    }
    
	private ArrayList<SelectItem> productoArray;
	
    public ArrayList<SelectItem> getProdcutoArray() {
    	productoArray= new ArrayList<SelectItem>();
		for (Product obj:service.getProducts(10))
		{
			productoArray.add(new SelectItem(obj.getId(),obj.getDescription()));
		}
		return productoArray;
	}

}
