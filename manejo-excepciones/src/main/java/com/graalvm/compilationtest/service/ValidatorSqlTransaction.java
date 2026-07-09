package com.graalvm.compilationtest.service;

import org.springframework.stereotype.Component;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.dao.CannotSerializeTransactionException;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.dao.NonTransientDataAccessResourceException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.dao.TransientDataAccessResourceException;
import com.graalvm.compilationtest.excepciones.SqlTransactionException;
import reactor.core.publisher.Mono;
import com.graalvm.compilationtest.model.objeto.Objeto;

@Component
public class ValidatorSqlTransaction {

    public Throwable detectarMotivoError(
            Throwable e,
            String clase,
            String metodo
    ) {

        String mensaje = obtenerMensaje(e);

        if (e instanceof DuplicateKeyException) {
            return new SqlTransactionException(
                    "DB_Datos duplicados",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof DataIntegrityViolationException) {
            return new SqlTransactionException(
                    "DB_Violación de integridad de los datos.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof QueryTimeoutException) {
            return new SqlTransactionException(
                    "DB_La consulta excedió el tiempo de espera.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof DataAccessResourceFailureException) {
            return new SqlTransactionException(
                    "DB_No fue posible conectar con la base de datos.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof TransientDataAccessResourceException) {
            return new SqlTransactionException(
                    "DB_La base de datos no está disponible temporalmente.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof NonTransientDataAccessResourceException) {
            return new SqlTransactionException(
                    "DB_La base de datos no está disponible.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof CannotAcquireLockException) {
            return new SqlTransactionException(
                    "DB_No fue posible obtener un bloqueo sobre los datos.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof DeadlockLoserDataAccessException) {
            return new SqlTransactionException(
                    "DB_Se detectó un deadlock en la base de datos.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof CannotSerializeTransactionException) {
            return new SqlTransactionException(
                    "DB_No fue posible completar la transacción.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof OptimisticLockingFailureException) {
            return new SqlTransactionException(
                    "DB_El registro fue modificado por otro proceso.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof PessimisticLockingFailureException) {
            return new SqlTransactionException(
                    "DB_No fue posible bloquear el registro.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof ConcurrencyFailureException) {
            return new SqlTransactionException(
                    "DB_Conflicto de concurrencia.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof PermissionDeniedDataAccessException) {
            return new SqlTransactionException(
                    "DB_Permisos insuficientes para acceder a la base de datos.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof InvalidDataAccessResourceUsageException) {
            return new SqlTransactionException(
                    "DB_Error en la consulta SQL.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof InvalidDataAccessApiUsageException) {
            return new SqlTransactionException(
                    "DB_Uso incorrecto de la API de acceso a datos.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        if (e instanceof RecoverableDataAccessException) {
            return new SqlTransactionException(
                    "DB_Error recuperable.",
                    mensaje,
                    clase,
                    metodo
            );
        }

        return e;
    }


    private String obtenerMensaje(Throwable e) {

        String mensaje = e.getMessage();

        if (mensaje == null) {
            return "Sin detalle";
        }

        String[] partes = mensaje.split(";");

        if (partes.length >= 4) {
            return partes[1]
                    + "\n"
                    + partes[2]
                    + "\n"
                    + partes[3];
        }

        return mensaje;
    }
}