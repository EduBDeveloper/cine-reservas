import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './AsientosGrid.css';

const AsientosGrid = () => {
    const [asientos, setAsientos] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/reservas/asientos')
            .then(res => setAsientos(res.data))
            .catch(err => console.error('Error cargando asientos:', err));
    }, []);

    const handleClick = async (asiento) => {
        if (asiento.reservado) {
            alert("Este asiento ya está reservado");
            return;
        }

        const cliente = prompt("Ingrese su nombre para reservar:");
        if (!cliente) return;

        try {
            const response = await axios.post('http://localhost:8080/api/reservas', {
                numero: asiento.numero,
                cliente
            });
            alert("Reserva exitosa");
            // Actualizar estado
            setAsientos(prev =>
                prev.map(a =>
                    a.numero === asiento.numero ? { ...a, reservado: true } : a
                )
            );
        } catch (err) {
            alert("Error al reservar: " + err.response.data);
        }
    };

    return (
        <div className="grid">
            {asientos.map(asiento => (
                <div
                    key={asiento.id}
                    className={`asiento ${asiento.reservado ? 'reservado' : 'disponible'}`}
                    onClick={() => handleClick(asiento)}
                >
                    {asiento.numero}
                </div>
            ))}
        </div>
    );
};

export default AsientosGrid;
