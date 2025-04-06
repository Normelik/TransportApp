import { Link } from 'react-router-dom';
import './Navbar.css';

type Props = {
  links: string[];
};

const Navbar = ({ links }: Props) => {
  return (
    <nav className="navbar">
      <Link to="/" className="logo">
        TransportApp
      </Link>
      <div className="nav-links">
        {links.map((item: string) => {
          const path = `/${item.toLowerCase()}`;
          return (
            <Link
              key={path}
              to={path}
              className={`nav-item ${location.pathname === path ? 'active' : ''}`}
            >
              {item}
            </Link>
          );
        })}
      </div>
    </nav>
  );
};

export default Navbar;
