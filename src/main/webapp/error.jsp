<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h2>Oops! Something went wrong 😢</h2>
    <p><strong>Error Message:</strong> ${errorMessage}</p>

    <p><strong>Requested URI:</strong> ${pageContext.request.requestURI}</p>

    <br/>
    <a href="index.html">Back to Home</a>
</body>
</html>
