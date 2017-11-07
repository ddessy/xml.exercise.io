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
							<xsl:call-template name="yearWithParam">
								<xsl:with-param name="yearName" select="year"/>
							</xsl:call-template>
						</td>
						<td>
							<xsl:call-template name="titleWithParam">
								<xsl:with-param name="titleName" select="title"/>
							</xsl:call-template>
						</td>
						<td>
							<xsl:call-template name="artistWithParam">
								<xsl:with-param name="artistName" select="artist"/>
							</xsl:call-template>
						</td>
					</tr>
				</xsl:for-each>
			</table>
		</body>	
	</html>
	</xsl:template>
	<xsl:template name="yearWithParam">
		<xsl:param name="yearName"/>
			<p>7.1: <xsl:value-of select="$yearName"/></p><br/>
	</xsl:template>
	<xsl:template name="titleWithParam">
		<xsl:param name="titleName"/>
			<p>7.2: <xsl:value-of select="$titleName"/></p><br/>
	</xsl:template>
	<xsl:template name="artistWithParam">
		<xsl:param name="artistName"/>
			<p>7.3: <xsl:value-of select="$artistName"/></p><br/>
	</xsl:template>
</xsl:stylesheet>