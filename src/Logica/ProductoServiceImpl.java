package Logica;

import java.util.ArrayList;

public class ProductoServiceImpl implements IProductoService{

	public ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	
	@Override
	public Producto buscarProducto(int codigo) {

		Producto productoEncontrado = null;
		for(Producto producto: listaProductos)
		{
			if(codigo == producto.getCodigo())
				productoEncontrado = producto;
		}
		return productoEncontrado;
	}

	@Override
	public boolean crearProducto(Producto producto) {
		
		if(producto!=null)
			{
			return true;
			}
		else {
			return false;
		}
	}

	
	
	
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	

	public void addListaProductos(Producto producto) {
		listaProductos.add(producto);
	}

	
	
	
	
	
	
	
	

}
