package br.com.handli.pessoa.config;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.handli.pessoa.errormessage.ErrorMessageEditable;
import br.com.handli.pessoa.modelo.Usuarios;

public class MailConfig {
  Usuarios usuarios2 = new Usuarios();

  public void enviarEmail(Usuarios usuarios){
    Properties props = new Properties();

    /** Parâmetros de conexão com servidor Gmail */
    props.put(
        "mail.smtp.host", 
        "smtp.gmail.com"
    );

    props.put(
        "mail.smtp.socketFactory.port",
        "465"
        );

    props.put(
        "mail.smtp.socketFactory.class",
        "javax.net.ssl.SSLSocketFactory"
    );

    props.put(
        "mail.smtp.auth",
        "true"
    );

    props.put(
        "mail.smtp.port",
        "465"
    );

    Session session = Session.getDefaultInstance(props,
      new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication()
           {
                 return new PasswordAuthentication(
                "",
                ""
                );
           }
      });

    /** Ativa Debug para sessão */
    // Usado para depurar problemas de SMTP
    session.setDebug(true);

    try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(""));
      //Remetente

      Address[] toUser = InternetAddress //Destinatário
                 .parse(usuarios.getEmail().toString());

      message.setRecipients(Message.RecipientType.TO, toUser);
      message.setSubject("Enviando email com JavaMail");//Assunto
      message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
      /**Método para enviar a mensagem criada*/
      Transport.send(message);


     } catch (MessagingException e) {
        throw new ErrorMessageEditable("Email informado não existe!");
     }
  }
}
