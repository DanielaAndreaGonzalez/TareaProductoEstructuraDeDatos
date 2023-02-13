package Logica;

import java.util.ArrayList;

public interface IProductoService {
	
	
	public boolean crearProducto(Producto producto);
	public Producto buscarProducto(int codigo);
	
	public ArrayList<Producto> getListaProductos();
	public void addListaProductos(Producto producto);

}
