<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" > 
	<xsl:template match="/">
		<html>
			<head>
				<title>Tatu Catalog</title>
			</head>
			<body>
				<h2>Tatu Catalog</h2>
				<table border="2" cellspacing="0px" cellpadding="5px">
					<thead>
						<tr>
							<th>CD Title</th>
							<th>Year</th>
							<th>Tracks without atributes</th>
							<th>Tracks with atributes</th>
						</tr>
					</thead>
					<tbody valign="top">
						<xsl:apply-templates select="catalog"/>
					</tbody>
				</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="cd">
		<tr>
			<td>
				<xsl:apply-templates select="title"/>
			</td>
			<td>
				<xsl:apply-templates select="year"/>
			</td>
			<td>
				<ol>
					<xsl:apply-templates select="tracklist/track" mode="withoutAttributes"/>
				</ol>
			</td>
			<td>
				<ol>
					<xsl:apply-templates select="tracklist/track" mode="withAttributes"/>
				</ol>
			</td>
		</tr>
	</xsl:template>
	<xsl:template match="catalog/cd/tracklist/track" mode="withAttributes">
		<li>
			<xsl:apply-templates select="text()"/> 
			<xsl:for-each select="@*">
				<br/><i>Atribute name:</i><xsl:value-of select="name()"/> - <i>atribute value:</i> <xsl:value-of select="."/>
			</xsl:for-each>
		</li>
	</xsl:template>
	<xsl:template match="catalog/cd/tracklist/track" mode="withoutAttributes">
		<li>
			<xsl:apply-templates select="text()"/> 
		</li>
	</xsl:template>
</xsl:stylesheet>