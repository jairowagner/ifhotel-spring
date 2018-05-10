package br.edu.ifrs.canoas.lds.webapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Usuario	
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Reserva  extends BaseEntity<Long> implements Serializable {
	
	private static final long serialVersionUID = -6363690009550605256L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Double valor;
	
	private LocalDate data;
	
	@ManyToOne
	private Pessoa cliente;
	
	@OneToOne
	private DiariaReservada diaria;
	
}