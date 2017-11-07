<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"> 
	<xsl:template match="/">
	<html>
		<body>
			<table border="2" cellspacing="0px" cellpadding="5px">
				<tr>
					<th>Year</th>
					<th>Title</th>
					<th>Artist</th>
				</tr>
				<xsl:for-each select="catalog/cd">
					<tr>
						<td>
							<xsl:call-template name="year"/>
						</td>
						<td>
							<xsl:call-template name="title"/>
						</td>
						<td>
							<xsl:call-template name="artist"/>
						</td>
					</tr>
				</xsl:for-each>
			</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template name="year">
		<b><xsl:value-of select="year"/></b><br/>
	</xsl:template>
	<xsl:template name="title">
		<b><xsl:value-of select="title"/></b><br/>
	</xsl:template>
	<xsl:template name="artist">
		<b><xsl:value-of select="artist"/></b><br/>
	</xsl:template>
</xsl:stylesheet>