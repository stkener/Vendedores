package ar.edu.unahur.obj2.vendedores

class Centro {

    val ciudad = null
    var vendedores = mutableListOf<Vendedor>()

    fun agregarVendedor(vendedor: Vendedor) {
        if (not vendedores.contains(vendedor)) {
            vendedores.add(vendedor)
        } else {
            this.error("El vendedor ya está agregado al centro")
        }
    }

    fun vendedorEstrella(): Vendedor {
        return vendedores.max({ vendedor -> vendedor.puntajeCertificaciones() })
    }

    fun puedeCubrirCiudad(ciudadUna: Ciudad) {
        vendedores.any({ vendedor -> vendedor.puedeTrabajarEn(ciudadUna) })
    }

    fun vendedoresGenericos(): Vendedor {
        return vendedores.filter({ vendedor -> vendedor.esGenerico() })
    }

    fun esRobusto(): Boolean{
        return this.vendedoresFirmes().size()>=3
    }

    fun vendedoresFirmes(): List<Vendedor> {
        return vendedores.filter({ vendedor -> vendedor.esFirme() })
    }

    fun esRobusto2(): Boolean {
        return vendedores.count({ vendedor -> vendedor.esFirme() }) >= 3
    }

    fun repartirCertificacion(certificacion: Certificacion) {
        vendedores.forEach({ vendedor -> vendedor.agregarCertificacion(certificacion) })
    }

}