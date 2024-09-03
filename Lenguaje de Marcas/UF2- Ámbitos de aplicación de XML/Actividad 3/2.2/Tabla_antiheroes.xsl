<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <link href="style.css" type="text/css" rel="stylesheet"/>
            </head>
            <body>
                <h1>Tabla de Antiheroes de Asier Rodriguez</h1>

                <xsl:for-each select="antiheroes/antiheroe">
                    <xsl:sort select="nombre" order="ascending"/>
                    <div class="padre">
                        <div class="foto">
                            <img src="{foto}"/>
                        </div>
                        <div class="descripcion">
                            <p>
                                <b><xsl:value-of select="nombre"/></b>
                            </p>
                            <p>                             
                                <b>Poder: </b>
                                <xsl:value-of select="poder"/>
                            </p>
                            <p>                               
                                <b>Fuerza: </b>
                                <xsl:value-of select="fuerza"/>
                            </p>
                            <p>
                                <b>Sexo: </b>
                                <xsl:value-of select="sexo"/>
                            </p>
                            <p>
                                <b>Comentario: </b>
                                <xsl:value-of select="comentario"/>
                            </p>
                        </div>
                    </div>
                </xsl:for-each>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
