package br.com.arvore.genealogica.exceptions;

import br.com.arvore.genealogica.dto.ErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ErroDTO> errorHandlerNegocioException(NegocioException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body(new ErroDTO(e.getMessage()));
    }

    @ExceptionHandler(AutorizacaoException.class)
    public ResponseEntity<ErroDTO> errorHandlerAutorizacaoExceptionn(AutorizacaoException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ErroDTO(e.getMessage()));
    }

}
