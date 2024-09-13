
package trabalho.tlp;


public class Cirurgia {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private Reserva reserva;

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
}
