package net.milkpoint.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.milkpoint.model.Abastecimento;
import net.milkpoint.model.Responsavel;
import net.milkpoint.model.Status;
import net.milkpoint.service.AbastecimentoService;
import net.milkpoint.service.ResponsavelService;

@RestController
@RequestMapping("/api")
public class AbastecimentoResource {

	@Autowired
	private AbastecimentoService abastecimentoService;

	public Abastecimento add(Abastecimento Abastecimento) {
		return abastecimentoService.save(Abastecimento);
	}

	@PostMapping("/deposito")
	public Abastecimento deposito(@RequestBody Abastecimento abastecimento) {
		if (abastecimento.getQuantidade() < 0) {
			abastecimento.setQuantidade(abastecimento.getQuantidade() * -1);
		}
		abastecimento.setTipo(Abastecimento.Tipo.DEPOSITO);
		return add(abastecimento);
	}

	@PostMapping("/retirada")
	public Abastecimento retirada(@RequestBody Abastecimento abastecimento) {
		if (abastecimento.getQuantidade() > 0) {
			abastecimento.setQuantidade(abastecimento.getQuantidade() * -1);
		}
		abastecimento.setTipo(Abastecimento.Tipo.RETIRADA);
		return add(abastecimento);
	}

	@GetMapping("/consulta")
	public List<Abastecimento> listar() {
		return abastecimentoService.findAll();
	}

	@GetMapping("/consulta/{id}")
	public ResponseEntity<Abastecimento> buscar(@PathVariable Long id) {
		Abastecimento Abastecimento = abastecimentoService.findOne(id);
		if (Abastecimento == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(Abastecimento);
	}

	@PostMapping("/confirma/{id}")
	public ResponseEntity<Abastecimento> confirmar(@PathVariable Long abastecimentoId, Long responsavelId) {
		Abastecimento abastecimento = abastecimentoService.findOne(abastecimentoId);
		Responsavel responsavel = new ResponsavelService().findOne(responsavelId);
		if (abastecimento == null || responsavel == null || abastecimento.getStatus() != Status.PENDENTE) {
			return ResponseEntity.notFound().build();
		}
		abastecimento.setStatus(Status.CONFIRMADO);
		abastecimento.setResponsavel(responsavel);
		abastecimentoService.save(abastecimento);
		return ResponseEntity.ok(abastecimento);
	}

	@PostMapping("/cancela/{id}")
	public ResponseEntity<Abastecimento> cancelar(@PathVariable Long abastecimentoId, Long responsavelId) {
		Abastecimento abastecimento = abastecimentoService.findOne(abastecimentoId);
		Responsavel responsavel = new ResponsavelService().findOne(responsavelId);
		if (abastecimento == null || responsavel == null || abastecimento.getStatus() != Status.PENDENTE) {
			return ResponseEntity.notFound().build();
		}
		abastecimento.setStatus(Status.CANCELADO);
		abastecimento.setResponsavel(responsavel);
		abastecimentoService.save(abastecimento);
		return ResponseEntity.ok(abastecimento);
	}
}
