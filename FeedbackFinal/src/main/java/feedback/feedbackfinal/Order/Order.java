package feedback.feedbackfinal.Order;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")  // <- muy importante
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Double total;
    private LocalDateTime fecha;

    public Order() {}

    public Order(String descripcion, Double total, LocalDateTime fecha) {
        this.descripcion = descripcion;
        this.total = total;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}

