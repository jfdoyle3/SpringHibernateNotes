<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="customers" %>
<!DOCTYPE html>
<html>
<head>

<title>Customer Registration Confirmation</title>
</head>
<body>
The customer is registered: ${customer.firstName} ${customer.lastName}
<br>
Free Passes: ${customer.freePasses}
<br>
Postal Code: ${customer.postalCode}
<br>
Course Code: ${customer.courseCode}
</body>
</html>