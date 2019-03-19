package br.com.caelum.teste;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.caelum.JpaConfigurator;

public class TesteC3P0 {

	public static void main(String[] args) throws PropertyVetoException, SQLException {
		
		ComboPooledDataSource dataSource = (ComboPooledDataSource) new JpaConfigurator().getDataSource();
		
		for (int i = 0; i < 10; i++) {
			dataSource.getConnection();
			
			System.out.println("Total de conexões: " + dataSource.getNumConnectionsDefaultUser());
			System.out.println("Conexões ocupadas: " + dataSource.getNumBusyConnectionsDefaultUser());
			System.out.println("Conexões ociosas: " + dataSource.getNumIdleConnectionsDefaultUser());
			System.out.println();
		}
		
		
		
	}
	
}
