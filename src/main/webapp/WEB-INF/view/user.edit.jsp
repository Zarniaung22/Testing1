
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>
<h1 style="text-align :center">Edit User</h1>
<div class="container" style="align :center">
    <form action="/user/edit">

        <div class="form-group">
            <label for="name">Your id is</label>
            <input type="text" value="" disabled="disabled" style="width: 30px">
            <input type="hidden"  value="@" name="id" style="width: 30px">
        </div>
        <div class="form-group">

            <label for="name">Enter your name</label>
            <input type="text" class="form-control" id="name" name="name" value="">
        </div>
        <div class="form-group">
            <label for="Email">Email address</label>
            <input type="email" class="form-control" id="email" name="email" value="">
        </div>
        <div class="form-group">
            <label for="phone">Phone No.</label>
            <input type="text" class="form-control" id="phone" name="phone" value="">
        </div>
        <div class="form-group">
            <label for="City">City</label>
            <input type="text" class="form-control"  id="city" name="city" value="" >
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
    </form></div>
<jsp:include page="footer.jsp"></jsp:include>
