<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <link href="style.css" type="text/css" rel="stylesheet"/>
            </head>
            <body>
                <h1>Asier Rodriguez</h1>

                <table>
                    <tr>
                        <th>Nombre</th>
                        <th>Poder</th>
                        <th>Foto</th>
                    </tr>

                    <xsl:for-each select="antiheroes/antiheroe">
                        <xsl:sort select="poder" order="descending"/>
                        <xsl:sort select="nombre" order="ascending"/>

                        <xsl:if test="poder='Agilidad'">

                            <tr style="background-color:red">
                                <td>
                                    <xsl:value-of select="nombre"/>
                                </td>
                                <td>
                                    <xsl:value-of select="poder"/>
                                </td>
                                <td>
                                    <img src="{foto}"/>
                                </td>
                            </tr>

                        </xsl:if>

                        <xsl:if test="poder='Transformacion'">

                            <tr style="background-color:blue">
                                <td>
                                    <xsl:value-of select="nombre"/>
                                </td>
                                <td>
                                    <xsl:value-of select="poder"/>
                                </td>
                                <td>
                                    <img src="{foto}"/>
                                </td>
                            </tr>

                        </xsl:if>

                        <xsl:if test="poder='Regeneracion'">

                            <tr style="background-color:orange">
                                <td>
                                    <xsl:value-of select="nombre"/>
                                </td>
                                <td>
                                    <xsl:value-of select="poder"/>
                                </td>
                                <td>
                                    <img src="{foto}"/>
                                </td>
                            </tr>

                        </xsl:if>

                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>