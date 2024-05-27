package br.edu.senaisp.Pastel.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Pastel.model.Sabor;

@Repository
public class PastelRepository {
	private String qrSelectAll = "SELECT id, sabor, descricao FROM pastel";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Sabor> lista() {

		return jdbcTemplate.query(qrSelectAll, (rs, rowNum) -> {
			return new Sabor(rs.getInt("id"), rs.getString("sabor"), rs.getString("descricao"));

		});
	}

	// ***************************COMANDO PARA
	// INSERIR********************************
	@SuppressWarnings("deprecation")

	public Sabor buscaPorId(int id) {
		String qrSelectById = "SELEct id, sabor, descricao FROM pastel WHERE id = ?";

		return jdbcTemplate.queryForObject(qrSelectById, new Object[] { id },
				(rs, rowNum) -> new Sabor(rs.getInt("id"), rs.getString("sabor"), rs.getString("descricao")));
	}

	// ***************************COMANDO PARA
	// ALTERAR********************************

	public Sabor altera(Sabor sabor, int id) {
		String qrUpdate = "UPDATE pastel SET sabor = ?, descricao = ? WHERE id = ?";

		jdbcTemplate.update(qrUpdate, sabor.getSabor(), sabor.getDescricao(), id);

		// retorna a Pastel atualizada
		return buscaPorId(id);
	}

	// ***************************COMANDO PARA
	// INSERIR********************************
	public int insere(Sabor sabor) {
		String qrInsert = "INSERT INTO pastel (sabor, descricao) VALUES (?, ?)";

		return jdbcTemplate.update(qrInsert, sabor.getSabor(), sabor.getDescricao());

	}

	// ***************************COMANDO PARA
	// EXCLUIR********************************

	public boolean exclui(int id) {
		String qrDelete = "DELETE FROM pastel WHERE id = ?";

		int rowsAffected = jdbcTemplate.update(qrDelete, id);

		return rowsAffected > 0; // Retorna true se pelo menos uma linha foi excluída
	}

	public Sabor insere(Sabor sabor, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
