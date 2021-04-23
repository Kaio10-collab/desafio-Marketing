package br.com.zup.Marketing.exceptions;

public class ObjetoDeErro {

    private Integer status = 400;
    private String tipoDeErro = "Contato não encontrada!";
    private String motivo = "BAD REQUEST";

    public ObjetoDeErro(Integer status, String tipoDeErro, String motivo) {
        this.status = status;
        this.tipoDeErro = tipoDeErro;
        this.motivo = motivo;
    }

    public ObjetoDeErro(String message) {

    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTipoDeErro() {
        return tipoDeErro;
    }

    public void setTipoDeErro(String tipoDeErro) {
        this.tipoDeErro = tipoDeErro;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}