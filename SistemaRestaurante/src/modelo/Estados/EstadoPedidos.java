/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Estados;

import modelo.Pedido;
import modelo.Pedido.EstadoPedido;
import modelo.RestauranteException;


    public abstract class EstadoPedidos {
        private Pedido pedido;
        private EstadoPedido estado;
        private String nombre;

        public EstadoPedidos(Pedido p, EstadoPedido estado, String nombre) {
            this.pedido = p;
            this.estado = estado;
            this.nombre = nombre;
        }

        public EstadoPedido getEstado(){
            return estado;
        }

        public String getNombre() {
            return nombre;
        }

        
        public abstract void confirmar() throws RestauranteException;

        public abstract void procesar() throws RestauranteException;

        public abstract void finalizar() throws RestauranteException;

        public abstract void entregar() throws RestauranteException;

        public Pedido getPedido(){
            return this.pedido;
        }
    }
