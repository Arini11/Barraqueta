<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<head>
  <style>
  .col {
      display: block;
      border: solid;
      border-width: thin;
      padding-left: 5px;
      padding-right: 5px;
      border-radius: 5px;
      width: 100%;
    }
    .row {
      display: table-row;
    }
  </style>
</head>
<body>
  <h2>Twitter Feed</h2>
  <xsl:for-each select="//channel">
          <div class="row">
            <div class="col"><xsl:value-of select="title"/></div>
            <div class="col"><xsl:value-of select="link"/></div>
          </div>
        </xsl:for-each>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
