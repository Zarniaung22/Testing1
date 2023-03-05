<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>
<h1 style="text-align :center">Create User</h1>
<div class="container" style="align :center">
    <form action="/user/create" method="post">
        <div class="form-group">
            <label for="name">Enter your name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="Email">Email address</label>
            <input type="email" class="form-control" id="Email" name="email">
        </div>
        <div class="form-group">
            <label for="phone">Phone No.</label>
            <input type="text" class="form-control" id="Phone" name="phone">
        </div>
        <div class="form-group">
            <label for="City">City</label>
            <input type="text" class="form-control"  id="City" name="city">
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form></div>
<jsp:include page="footer.jsp"></jsp:include>
