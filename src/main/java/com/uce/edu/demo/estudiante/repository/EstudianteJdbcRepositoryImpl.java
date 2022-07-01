package com.uce.edu.demo.estudiante.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2EcApplication;
import com.uce.edu.demo.estudiante.to.EstudianteTo;
@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {
	
	private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2EcApplication.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EstudianteTo buscarPorId(int id) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("select * from estudiante where id=?", new Object[] { id },
				new BeanPropertyRowMapper<EstudianteTo>(EstudianteTo.class));
	}

	@Override
	public void insertar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into estudiante (id,nombre,apellido,edad,genero) values (?,?,?,?,?)",
				new Object[] { estudiante.getId(), estudiante.getNombre(), estudiante.getApellido(),
						estudiante.getEdad(), estudiante.getGenero() });
	}

	@Override
	public void actualizar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update estudiante set nombre=?,apellido=?,edad=?,genero=? where id=?",
				new Object[] { estudiante.getNombre(), estudiante.getApellido(), estudiante.getEdad(),
						estudiante.getGenero(), estudiante.getId() });
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		LOG.info("Se elimino el Estudiante con id:"+id);
		this.jdbcTemplate.update("delete from estudiante where id=?", new Object[] { id });
	}

}
