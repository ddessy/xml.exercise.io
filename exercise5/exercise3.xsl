<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"> 
<xsl:output method="html"/>
   <xsl:template match="/"> 
      <html> 
         <body> 
            <table> 
               <tr> 
                  <td> 3.1. 
                     <ol> 
                        <xsl:for-each select="catalog/cd/tracklist/track"> 
							<xsl:sort select="."/> 
							<li><xsl:value-of select="text()"/></li> 
                        </xsl:for-each>
                     </ol>
                  </td> 
               </tr> 
               <tr> 
                  <td> 3.2. 
                     <ol> 
                        <xsl:for-each select="catalog/cd/tracklist/track"> 
                         	<xsl:sort select="." order="descending"/> 
							<li><xsl:value-of select="text()"/></li> 
                        </xsl:for-each>
                     </ol>
                  </td> 
               </tr> 
			   <tr> 
                  <td> 3.3. 
					<xsl:for-each select="catalog/cd/tracklist/track"> 
						<xsl:sort select="." order="descending"/> 
						<xsl:value-of select="text()"/>
						<xsl:if test="position() != last()">
							<xsl:text>, </xsl:text>
						</xsl:if>
					</xsl:for-each>
                  </td> 
               </tr> 
            </table>              
         </body> 
      </html> 
   </xsl:template> 
</xsl:stylesheet>