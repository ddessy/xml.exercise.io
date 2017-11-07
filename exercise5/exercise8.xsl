<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" > 
<xsl:output method="xml"/>
	<xsl:template match="catalog">
		<result>
			<xsl:for-each select="cd">
				<cd>   
					<title>
						<xsl:value-of select="title"/>
					</title>
					<xsl:copy-of select="tracklist" />
				</cd>
			</xsl:for-each>
		</result>
	</xsl:template>
</xsl:stylesheet>