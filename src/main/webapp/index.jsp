<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Responsive Registration Page</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5, #acb6e5);
            font-family: Arial, sans-serif;
            color: #333;
            margin: 0;
            padding: 0;
        }

        #frm {
            width: 90%;
            max-width: 550px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            animation: fadeIn 1.2s ease-in-out;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h2.card-header {
            border-radius: 10px 10px 0 0;
            text-align: center;
            background: #ff4d4d;
            color: white;
            padding: 10px;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1rem;
        }

        label {
            font-weight: bold;
        }

        button {
            width: 100px;
            padding: 10px;
            margin: 5px;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        button:hover {
            transform: scale(1.05);
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.3);
        }

        .btn-outline-primary {
            background-color: #007bff;
            color: white;
        }

        .btn-outline-primary:hover {
            background: linear-gradient(45deg, #0056b3, #007bff);
        }

        .btn-outline-danger {
            background-color: #dc3545;
            color: white;
        }

        .btn-outline-danger:hover {
            background: linear-gradient(45deg, #a71d2a, #dc3545);
        }

        .btn-link {
            background-color: #28a745;
            color: white;
            display: block;
            text-align: center;
            margin: 15px auto;
            text-decoration: none;
            padding: 10px 0;
            border-radius: 5px;
        }

        .btn-link:hover {
            background-color: #1e7a38;
        }

        .button-group {
            display: flex;
            justify-content: center;
            gap: 10px;
        }

        @media (max-width: 768px) {
            h2.card-header {
                font-size: 1.2rem;
            }

            input, select, button {
                font-size: 0.9rem;
            }

            .button-group {
                flex-direction: column;
                align-items: center;
            }
        }
    </style>
</head>
<body class="container-fluid">
    <marquee><h2 class="text-primary">Register Here</h2></marquee>
    <form action="RegisterServlet" method="get" class="form card" id="frm">
        <h2 class="bg-danger text-white card-header">Registration Form</h2>
        <table class="table table-hover">
            <tr>
                <td><label for="userName">Name</label></td>
                <td><input type="text" id="userName" name="userName" placeholder="Enter your name" required></td>
            </tr>
            <tr>
                <td><label for="email">Email</label></td>
                <td><input type="email" id="email" name="email" placeholder="Enter your email" required></td>
            </tr>
            <tr>
                <td><label for="mobile">Mobile</label></td>
                <td><input type="text" id="mobile" name="mobile" placeholder="Enter your mobile number" required></td>
            </tr>
            <tr>
                <td><label for="dob">DOB</label></td>
                <td><input type="date" id="dob" name="dob" required></td>
            </tr>
            <tr>
                <td><label for="city">City</label></td>
                <td>
                    <select id="city" name="city">
                        <option value="Rajkot">Rajkot</option>
                        <option value="Ahmedabad">Ahmedabad</option>
                        <option value="Pune">Pune</option>
                        <option value="Mumbai">Mumbai</option>
                        <option value="Delhi">Delhi</option>
                        <option value="Hyderabad">Hyderabad</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Gender</label></td>
                <td>
                    <input type="radio" id="male" name="gender" value="male" required>
                    <label for="male">Male</label>

                    <input type="radio" id="female" name="gender" value="female" required>
                    <label for="female">Female</label>
                </td>
            </tr>
        </table>
        <div class="button-group">
            <button type="submit" class="btn btn-outline-primary">Register</button>
            <button type="reset" class="btn btn-outline-danger">Cancel</button>
        </div>
        <a href="ShowUserServlet" class="btn-link">Show Users</a>
    </form>
</body>
</html>
