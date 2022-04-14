package br.com.handli.pessoa.errormessage;

public class ProfessorSalaError extends RuntimeException{
    
    public ProfessorSalaError(String message){
        super(message);
    }
}
