import React from 'react';

function Footer() {
  return (
    <footer className="bg-dark text-light pt-5 pb-3 mt-5">
      <div className="container">
        <div className="row">

          {/* About Section */}
          <div className="col-md-4 mb-4">
            <h5 className="mb-3">About Us</h5>
            <p className="text-white">
              We provide high-quality, affordable online courses led by
              industry experts to help learners build real-world skills
              and achieve their career goals.
            </p>
          </div>

          {/* Quick Links */}
          <div className="col-md-2 mb-4">
            <h5 className="mb-3">Quick Links</h5>
            <ul className="list-unstyled">
              <li><a href="#" className="text-light text-decoration-none">Home</a></li>
              <li><a href="#" className="text-light text-decoration-none">Courses</a></li>
              <li><a href="#" className="text-light text-decoration-none">Instructors</a></li>
              <li><a href="#" className="text-light text-decoration-none">About</a></li>
              <li><a href="#" className="text-light text-decoration-none">Contact</a></li>
            </ul>
          </div>

          {/* Support */}
          <div className="col-md-3 mb-4">
            <h5 className="mb-3">Support</h5>
            <ul className="list-unstyled">
              <li><a href="#" className="text-light text-decoration-none">Help Center</a></li>
              <li><a href="#" className="text-light text-decoration-none">FAQs</a></li>
              <li><a href="#" className="text-light text-decoration-none">Privacy Policy</a></li>
              <li><a href="#" className="text-light text-decoration-none">Terms & Conditions</a></li>
            </ul>
          </div>

          {/* Contact Info */}
          <div className="col-md-3 mb-4">
            <h5 className="mb-3">Contact Us</h5>
            <p className="mb-1">📧 support@learn.com</p>
            <p className="mb-1">📞 +91 98765 43210</p>
            <p className="mb-1">📍 India</p>
          </div>

        </div>

        <hr className="border-secondary" />

        {/* Bottom Footer */}
        <div className="text-center text-white">
          © {new Date().getFullYear()} L...earn. All Rights Reserved.
        </div>
      </div>
    </footer>
  );
}

export default Footer;
