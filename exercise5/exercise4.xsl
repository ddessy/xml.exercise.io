<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"> 
   <xsl:template match="/"> 
      <html> 
         <body> 
            <table> 
               <tr> 
                  <td> 
                     <table border="2" bordercolor="blue" cellspacing="0" cellpadding="2"> 
                        <xsl:variable name="header" > 
                              Description 
                        </xsl:variable> 
                        <xsl:for-each select="catalog/cd/tracklist/track"> 
                           <xsl:sort select="text()" order="descending"/> 
                           <tr> 
                              <th> 
                                 <xsl:value-of select="$header"/> 
                              </th> 
                           </tr> 
                           <tr> 
                              <td> 
                                 <xsl:value-of select="."/> 
                              </td> 
                           </tr> 
                        </xsl:for-each> 
                     </table> 
                  </td> 
               </tr> 
            </table>              
         </body> 
      </html> 
   </xsl:template> 
</xsl:stylesheet>