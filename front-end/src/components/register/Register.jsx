import React, { useState } from 'react'
import { useForm } from 'react-hook-form'
import registerImg from '../../assets/register.png'

function Register() {

  const [isLogin, setIsLogin] = useState(false)
  const [showPassword, setShowPassword] = useState(false)

  const {
    register,
    handleSubmit,
    watch,
    reset
  } = useForm()

  const role = watch("role")

  // 🔹 Common submit handler
  const onSubmit = (data) => {
    if (isLogin) {
      console.log("LOGIN DATA 👉", data)
    } else {
      console.log("REGISTER DATA 👉", data)
    }

    // later → API call here
    reset()
  }

  return (
    <div className="container-fluid" style={{ paddingTop: '120px', paddingLeft: '50px', paddingRight: '50px' }}>
      <div className="row align-items-center">

        {/* Left Image */}
        <div className="col-md-7 d-none d-md-block">
          <img src={registerImg} alt="auth" style={{ width: '100%', borderRadius: '15px' }} />
        </div>

        {/* Right Form */}
        <div className="col-md-5 col-12 text-white">
          <div className="shadow p-4 rounded">

            <h3 className="text-center mb-4 fw-bold">
              {isLogin ? "Login" : "Create Account"}
            </h3>

            <form onSubmit={handleSubmit(onSubmit)}>

              {/* Role (Both Login & Register) */}
              <div className="mb-3">
                <label className="form-label">Login / Register As</label>
                <select
                  className="form-select"
                  {...register("role")}
                  style={{ backgroundColor: 'black', color: 'wheat' }}
                >
                  <option value="student">Student</option>
                  <option value="instructor">Instructor</option>
                </select>
              </div>

              {/* Register-only fields */}
              {!isLogin && (
                <>
                  <div className="mb-3">
                    <label className="form-label">First Name</label>
                    <input
                      className="form-control"
                      {...register("firstName")}
                      placeholder="First name"
                      style={{ backgroundColor: 'black', color: 'wheat' }}
                    />
                  </div>

                  <div className="mb-3">
                    <label className="form-label">Last Name</label>
                    <input
                      className="form-control"
                      {...register("lastName")}
                      placeholder="Last name"
                      style={{ backgroundColor: 'black', color: 'wheat' }}
                    />
                  </div>
                </>
              )}

              {/* Email */}
              <div className="mb-3">
                <label className="form-label">Email</label>
                <input
                  type="email"
                  className="form-control"
                  {...register("email")}
                  placeholder="Email"
                  style={{ backgroundColor: 'black', color: 'wheat' }}
                />
              </div>

              {/* Password */}
              <div className="mb-3">
                <label className="form-label">Password</label>
                <input
                  type={showPassword ? "text" : "password"}
                  className="form-control"
                  {...register("password")}
                  placeholder="Password"
                  style={{ backgroundColor: 'black', color: 'wheat' }}
                />
              </div>

              {/* Confirm Password (Register only) */}
              {!isLogin && (
                <div className="mb-3">
                  <label className="form-label">Confirm Password</label>
                  <input
                    type={showPassword ? "text" : "password"}
                    className="form-control"
                    {...register("confirmPassword")}
                    placeholder="Confirm password"
                    style={{ backgroundColor: 'black', color: 'wheat' }}
                  />
                </div>
              )}

              {/* Instructor-only */}
              {!isLogin && role === "instructor" && (
                <div className="mb-3">
                  <label className="form-label">Bio</label>
                  <textarea
                    className="form-control"
                    rows="3"
                    {...register("bio")}
                    placeholder="Tell something about yourself"
                    style={{ backgroundColor: 'black', color: 'wheat' }}
                  />
                </div>
              )}

              {/* Show password */}
              <div className="form-check mb-3">
                <input
                  className="form-check-input"
                  type="checkbox"
                  onChange={() => setShowPassword(!showPassword)}
                />
                <label className="form-check-label">Show Password</label>
              </div>

              <button className="btn btn-primary w-100">
                {isLogin ? "Login" : "Register"}
              </button>

            </form>

            {/* Toggle */}
            <p className="text-center mt-3">
              {isLogin ? "Don't have an account?" : "Already have an account?"}{' '}
              <span
                className="text-primary"
                style={{ cursor: 'pointer' }}
                onClick={() => {
                  setIsLogin(!isLogin)
                  reset()
                }}
              >
                {isLogin ? "Register" : "Login"}
              </span>
            </p>

          </div>
        </div>
      </div>
    </div>
  )
}

export default Register
